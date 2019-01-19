package br.com.sdvs.cdr.repository;

import br.com.sdvs.cdr.model.DbImportConnection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbImportConnectionReposiroty extends JpaRepository<DbImportConnection, Long> {

    public DbImportConnection findOneByConnection(String connection);
}
