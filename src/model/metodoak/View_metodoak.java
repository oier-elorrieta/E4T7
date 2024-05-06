package model.metodoak;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

import model.Abestia;
import salbuespenak.DataBalidazioaException;

public class View_metodoak {
	
	// BOTOIAK 
	public static JButton btn_Atzera() {
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setFont(new Font("SansSerifs", Font.PLAIN, 16));
		btnAtzera.setBounds(24, 15, 110, 37);
		btnAtzera.setFocusPainted(false);
		
		return btnAtzera;
	}
	
	public static JButton btn_NireProfila() {
		JButton btnNireProfila = new JButton("Nire profila");
		btnNireProfila.setFont(new Font("Trebuchet MS", Font.PLAIN, 13));
		btnNireProfila.setBounds(730, 49, 115, 27);
		btnNireProfila.setFocusPainted(false);
		
		return btnNireProfila;
	}
	
	public static void playHurrengoaAbestia(Clip clipHurrengoa, Clip clipLehena, String fileAudio) {
		File f = new File(fileAudio);
		AudioInputStream aui2;
		
		try {
			aui2 = AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			clipHurrengoa = AudioSystem.getClip();
			clipHurrengoa.open(aui2);
		} catch (UnsupportedAudioFileException | IOException ew) {
			ew.printStackTrace();
		} catch (LineUnavailableException e1) {
			e1.printStackTrace();
		}
		
		
		if (clipLehena.isRunning()) {
			clipLehena.stop();
		}
		if (clipHurrengoa.isRunning()) {
			clipHurrengoa.stop();
		}
	}
		
	
	public static void dataBalidatu(String date) throws DataBalidazioaException {
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new DataBalidazioaException();
        }
    }
	
	public static void skipBaimendu() {
        
        Timer timer = new Timer();
        
        TimerTask task = new TimerTask() {
            public void run() {
                SesioAldagaiak.skip_abestia = true;
                System.out.println("skip");
            }
        };
        
        timer.schedule(task, 10000);
    }
	
	@SuppressWarnings("deprecation")
	public static String dateToString (Date dataAldatzeko) {
		
		if (dataAldatzeko.getMonth() >= 0 && dataAldatzeko.getMonth() <= 9) {
			int intdataMonth = dataAldatzeko.getMonth();
			String StrdataMonth = "0" + intdataMonth;
			int dataMonthondo = Integer.parseInt(StrdataMonth);
			Date data = new Date(dataAldatzeko.getYear(), dataMonthondo, dataAldatzeko.getDay());
			DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");  
	        String strDate = dateFormat.format(data); 
	        return strDate;
		} else {
			Date data = new Date(dataAldatzeko.getYear(), dataAldatzeko.getMonth(), dataAldatzeko.getDay());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	        String strDate = dateFormat.format(data);
	        return strDate;
		}
	}
	
	public static Date stringToDate (String data) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);

		Date date = formatter.parse(data);
		return date;
	}
}
