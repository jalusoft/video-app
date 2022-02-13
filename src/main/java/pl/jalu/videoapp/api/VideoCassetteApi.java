package pl.jalu.videoapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jalu.videoapp.dao.entity.VideoCassette;
import pl.jalu.videoapp.manager.VideoCassetteManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCassetteApi {

    private final VideoCassetteManager videoCassetteManager;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassetteManager) {
        this.videoCassetteManager = videoCassetteManager;
    }

    @GetMapping("/all")
    public Iterable<VideoCassette> getAll() {
        return videoCassetteManager.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {
        return videoCassetteManager.findById(index);
    }

    @PostMapping
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassetteManager.save(videoCassette);
    }

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {
        return videoCassetteManager.save(videoCassette);
    }

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {
        videoCassetteManager.deleteById(index);
    }
}
