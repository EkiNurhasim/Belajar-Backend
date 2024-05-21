package ekiasari.spring.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ekiasari.spring.core.repository.CatRepository;
import lombok.Getter;

@Component
public class CatService {

    @Getter
    private CatRepository catRepository;

    @Autowired
    public void setCatRepository(CatRepository catRepository) {
        this.catRepository = catRepository;
    }
}
