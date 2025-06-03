package com.gs.gsjava.repository;

import com.gs.gsjava.model.Leitura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface LeituraRepository extends JpaRepository<Leitura, Long> {
	
	@Query("SELECT new map(l.sensor.regiao.nome as regiao, AVG(l.temperatura) as media) " +
		       "FROM Leitura l GROUP BY l.sensor.regiao.nome")
		List<Map<String, Object>> buscarMediaTemperaturaPorRegiao();

}
