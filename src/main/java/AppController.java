@RestController
@RequestMapping("/auth")
public class AuthController {
    private UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<AuthTokenDTO> login(@Valid @RequestBody AuthLoginDTO login) throws Exception {
        var user = userService.loginUser(login.getEmail(), login.getPassword());
        if (user == null) {
            throw new ValidationException("Username does not exist");
        }

        try {
            var token = JwtAuthFilter.generateToken(user);
            return ResponseEntity.ok(new AuthTokenDTO(token));
        } catch (Exception exception){
            return ResponseEntity.internalServerError().build();
        }