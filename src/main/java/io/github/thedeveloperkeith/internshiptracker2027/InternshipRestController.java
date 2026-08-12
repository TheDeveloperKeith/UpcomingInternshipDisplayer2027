package io.github.thedeveloperkeith.internshiptracker2027;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api/items")
public class InternshipRestController {

    private final InternshipRepo internshiprepo;

    @Autowired
    public InternshipRestController(InternshipRepo internshiprepo) {
        this.internshiprepo = internshiprepo;
    }

    @GetMapping
    public List<InternshipEntity> getAllProducts() {
        return internshiprepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InternshipEntity> getproductId(@PathVariable Long id) {
        return internshiprepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public InternshipEntity createProduct(@RequestBody InternshipEntity val) {
        return internshiprepo.save(val);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {

        if (!internshiprepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        internshiprepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}

