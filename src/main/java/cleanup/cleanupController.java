import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/cleanup")
class CleanupController {
    private UserService userService;
    private Service Service;

    CleanupController(UserService userService, Service Service) {
        this.userService = userService;
        this.Service = Service;
    }

    @DeleteMapping()
    @PreAuthorize("permitAll()")
    public ResponseEntity cleanup() {
        Service.deleteAll();
        userService.deleteAll();
        return ResponseEntity.ok().build();
    }
}