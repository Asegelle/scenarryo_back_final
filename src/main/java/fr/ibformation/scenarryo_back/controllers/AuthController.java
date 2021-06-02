package fr.ibformation.scenarryo_back.controllers;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import fr.ibformation.scenarryo_back.payload.request.LoginRequest;
import fr.ibformation.scenarryo_back.payload.request.SignupRequest;
import fr.ibformation.scenarryo_back.payload.response.JwtResponse;
import fr.ibformation.scenarryo_back.payload.response.MessageResponse;
import fr.ibformation.scenarryo_back.repository.RoleRepository;
import fr.ibformation.scenarryo_back.repository.UserRepository;
import fr.ibformation.scenarryo_back.security.jwt.JwtUtils;
import fr.ibformation.scenarryo_back.security.services.UserDetailsImpl;

import fr.ibformation.scenarryo_back.beans.CinemaRole;
import fr.ibformation.scenarryo_back.beans.CinemaUser;
import fr.ibformation.scenarryo_back.enums.RoleEnum;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	
    // ------------------------- Autowired --------------------------

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	
    // ------------------------- post --------------------------
	
	// post of the form to sign-in
	/**
	 * function authenticateUser :
	 * to verify users info, validate signin if ok and generate an access token for the session
	 * @param loginRequest (object associated to the speficif form of login)
	 * @return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles))
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		// to validate object
		Authentication authentication = authenticationManager.authenticate(
				// gets {username, password} from login Request
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		// Once the authentication server confirms the identity of the client, an access token (JWT) is generated
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		// If successful : returns a fully populated Authentication object
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	// post of the form to sign-up
	/**
	 * function registerUser :
	 * to create account for a new user
	 * @param signUpRequest (object associated to the speficif form of signUp)
	 * @return ResponseEntity.ok(new MessageResponse("L'utilisateur s'est enregistré avec succès !"))
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		// verify if username already exists
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Erreur : Nom Utilisateur déjà pris !"));
		}
		// verify if email already exists
		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Erreur : Email déjà utilisé !"));
		}

		// Create new user's account
		CinemaUser user = new CinemaUser(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<CinemaRole> roles = new HashSet<>();
		
		// if no role to this user : set as user (for general use of the web site)
		if (strRoles == null) {
			CinemaRole userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Erreur : Rôle non trouvé."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					CinemaRole adminRole = roleRepository.findByName(RoleEnum.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Erreur : Rôle non trouvé."));
					roles.add(adminRole);

					break;
				case "mod":
					CinemaRole modRole = roleRepository.findByName(RoleEnum.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Erreur : Rôle non trouvé."));
					roles.add(modRole);

					break;
				default:
					CinemaRole userRole = roleRepository.findByName(RoleEnum.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Erreur : Rôle non trouvé."));
					roles.add(userRole);
				}
			});
		}
		
		// save new user in bdd
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("L'utilisateur s'est enregistré avec succès !"));
	}
}