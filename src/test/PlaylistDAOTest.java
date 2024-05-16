package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import model.E_Free;
import model.Playlist;
import model.metodoak.SesioAldagaiak;
import model.sql.PlayListDAO;

public class PlaylistDAOTest {

	
    @Test
    public void testPlayListakKargatuBezeroa() throws SQLException {
		SesioAldagaiak.bezeroa_logeatuta = new E_Free("a&", "a&", "a&", null, null, null);
		SesioAldagaiak.bezeroa_logeatuta.setIdBezeroa("a&");
        ArrayList<Playlist> expectedPlaylists = new ArrayList<>();
        expectedPlaylists.add(new Playlist(18, "asas", 1, new Date()));
       
        
        ArrayList<Playlist> actualPlaylists = PlayListDAO.playListakKargatuBezeroa();
        
        assertEquals(expectedPlaylists.size(), actualPlaylists.size());
        
     
            Playlist expectedPlaylist = expectedPlaylists.get(0);
            Playlist actualPlaylist = actualPlaylists.get(0);
            
            assertEquals(expectedPlaylist.getIdPlaylist(), actualPlaylist.getIdPlaylist());
            assertEquals(expectedPlaylist.getTitulua(), actualPlaylist.getTitulua());
            assertEquals(expectedPlaylist.getKapazitatea(), actualPlaylist.getKapazitatea());
        }
    
    
    
    
    }

