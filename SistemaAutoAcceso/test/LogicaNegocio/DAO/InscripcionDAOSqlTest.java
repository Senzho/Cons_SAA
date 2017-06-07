/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio.DAO;

import LogicaNegocio.Entidades.Inscripcion;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InscripcionDAOSqlTest {
    private String matricula;
    
    public InscripcionDAOSqlTest() {
        matricula = "S15011633";
    }
    
    @Test
    public void testGetListaInscripciones() {
        InscripcionDAOSql inscripcionDao = new InscripcionDAOSql();
        int longitud = 0;
        assertNotEquals(inscripcionDao.getListaInscripciones(matricula), longitud);
    }
    
}
