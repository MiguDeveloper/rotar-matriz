package pe.tuna.rotarmatriz.service;

import pe.tuna.rotarmatriz.models.entity.MiArreglo;

import java.util.List;

public interface IMiArregloService {
    public List<MiArreglo> findAll();
    public MiArreglo save(MiArreglo miArreglo);
    public void delete(Long id);
}
