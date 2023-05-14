package com.example.nosql_backend.controller;
import com.example.nosql_backend.entity.invertedindex;
import com.example.nosql_backend.repo.InvertedIndexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class InvertedIndexController {

    @Autowired
    private InvertedIndexRepository invertedIndexRepository;

    @GetMapping("/search/{word}")
    public ResponseEntity<invertedindex.Doc[]> searchWord(@PathVariable String word) {
        System.out.println("the entered word is:" +word);
        invertedindex invertedIndex = invertedIndexRepository.findByWord(word);


        if (invertedIndex != null) {
            invertedindex.Doc[] docs = invertedIndex.getDocs();
//            System.out.println(docs);
            return ResponseEntity.ok().body(docs);
        }
        System.out.println("not found");
        return ResponseEntity.notFound().build();
    }
}
