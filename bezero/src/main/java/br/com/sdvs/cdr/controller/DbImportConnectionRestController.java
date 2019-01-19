package br.com.sdvs.cdr.controller;

        import java.util.List;

        import javax.servlet.http.HttpServletRequest;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;
        import org.springframework.data.web.PageableDefault;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.MediaType;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import br.com.sdvs.cdr.model.DbImportConnection;
        import br.com.sdvs.cdr.repository.DbImportConnectionReposiroty;

@RestController
@RequestMapping("dbimportconnections")
public class DbImportConnectionRestController {

    @Autowired
    private DbImportConnectionReposiroty repository;

    @RequestMapping(value = "pageable", method = RequestMethod.GET)
    public ResponseEntity<Page<DbImportConnection>> listSearchJpa(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<DbImportConnection> page = repository.findAll(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DbImportConnection>> findAll(){
        List<DbImportConnection> list = repository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DbImportConnection> findOne(@PathVariable("id") Long id){
        DbImportConnection entity = repository.findOne(id);
        HttpStatus returnStatus = HttpStatus.OK;
        if(entity == null) {
            returnStatus = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity<>(entity, returnStatus);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DbImportConnection> create(@RequestBody DbImportConnection entity, HttpServletRequest request){
        DbImportConnection currentEntity = repository.findOneByConnection(entity.getConnection());
        if (currentEntity!=null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DbImportConnection> update(HttpServletRequest request, @PathVariable("id") Long id, @RequestBody DbImportConnection entity) {
        DbImportConnection currentEntity = repository.findOne(id);
        if (currentEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.save(entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<DbImportConnection> delete(HttpServletRequest request, @PathVariable("id") Long id) {
        DbImportConnection currentEntity = repository.findOne(id);
        if (currentEntity==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            repository.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}