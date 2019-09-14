package com.karen_velasquez.www.ProGit;

import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("minibuses")
class MinibusController {

  private final MinibusRepository repository;

  MinibusController(MinibusRepository repository) {
    this.repository = repository;
  }
 

  // Aggregate root

  @GetMapping("/minibuses")
  List<Minibus> all() {
    return repository.findAll();
  }

  @PostMapping("/minibuses")
  Minibus newMinibus(@RequestBody Minibus newMinibus) {
    return repository.save(newMinibus);
  }
 

  // Single item
 /*
  @GetMapping("/minibuses/{id}")
  Resource<Minibus> two(@PathVariable Long id) {
    Minibus minibus = repository.findById(id)
      .orElseThrow(() -> new MinibusNotFoundException(id));
    return new Resource<>(minibus,
      linkTo(methodOn(MinibusController.class).two(id)).withSelfRel(),
      linkTo(methodOn(MinibusController.class).all()).withRel("minibuses"));
  }
 */
 /* @GetMapping("/minibuses/{id}")
  Resource<Minibus> three(@PathVariable Long id) {

    Minibus minibus = repository.findById(id)
      .orElseThrow(() -> new MinibusNotFoundException(id));

    return new Resource<>(minibus,
      linkTo(methodOn(MinibusController.class).three(id)).withSelfRel(),
      linkTo(methodOn(MinibusController.class).all()).withRel("minibuses"));
  }*/
  @GetMapping("/minibuses/{id}")
  Minibus one(@PathVariable Long id) {

    return repository.findById(id)
      .orElseThrow(() -> new MinibusNotFoundException(id));
  }

  @PutMapping("/minibuses/{id}")
  Minibus replaceMinibus(@RequestBody Minibus newMinibus, @PathVariable Long id) {

    return repository.findById(id)
      .map(minibus -> {
        minibus.setNumero(newMinibus.getNumero());
        minibus.setP_partida(newMinibus.getP_partida());
        return repository.save(minibus);
      })
      .orElseGet(() -> {
        newMinibus.setId(id);
        return repository.save(newMinibus);
      });
}

  @DeleteMapping("/minibuses/{id}")
  void deleteMinibus(@PathVariable Long id) {
    repository.deleteById(id);
  }
  
}