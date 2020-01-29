package pe.tuna.rotarmatriz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.tuna.rotarmatriz.models.entity.MiArreglo;

@Repository
public interface IMiArregloRespository extends JpaRepository<MiArreglo, Long> {
}
