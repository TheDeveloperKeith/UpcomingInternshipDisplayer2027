package io.github.thedeveloperkeith.internshiptracker2027;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;




@RestController
@RequestMapping("/api/items")
public class InternshipRestController {

    private final Internship internshiprepo;

    @Autowired
    public InternshipRestController(Internship internshiprepo) {
        this.internshiprepo = internshiprepo;
    }

    @GetMapping
    public List<internshiptable> getAllProducts() {
        return internshiprepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<internshiptable> getproductId(@PathVariable Long id) {
        return internshiprepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public internshiptable createProduct(@RequestBody internshiptable val) {
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

