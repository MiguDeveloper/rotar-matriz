package pe.tuna.rotarmatriz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.tuna.rotarmatriz.models.entity.MiArreglo;
import pe.tuna.rotarmatriz.repository.IMiArregloRespository;
import pe.tuna.rotarmatriz.service.IMiArregloService;

import java.util.List;

@Service
public class MiArregloServiceImpl implements IMiArregloService {

    @Autowired
    private IMiArregloRespository miArregloRespository;

    @Override
    public List<MiArreglo> findAll() {
        return miArregloRespository.findAll();
    }

    @Override
    @Transactional()
    public MiArreglo save(MiArreglo miArreglo) {
        return miArregloRespository.save(miArreglo);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        miArregloRespository.deleteById(id);
    }
}
