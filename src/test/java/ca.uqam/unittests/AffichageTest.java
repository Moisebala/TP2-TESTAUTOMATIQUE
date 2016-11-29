package ca.uqam.unittests;
import ca.uqam.model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * Created by Mo-is-Balla on 2016-11-14.
 */
public class AffichageTest {
    Vehicule  vehicule , vehicule1;

    @Before
    public void setUp() throws Exception {
        vehicule = new Vehicule("789593","Honda","C220","Sedan","2016","120", Etatvoiture.Disponile);
        vehicule1 = new Vehicule("789592","BmW","C220","Sedan","2016","120", Etatvoiture.Louer);


    }

    @Test
    public void Displayvehicule() throws Exception {
        String matricule =vehicule.getMatricule();
        Etatvoiture status =vehicule.getState();
        assertEquals(status,Etatvoiture.Disponile);
        assertEquals(matricule,"789593");


    }

}
