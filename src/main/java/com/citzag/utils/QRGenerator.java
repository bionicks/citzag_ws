package com.citzag.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;





public class QRGenerator {
	
	 public static BufferedImage gen(String args ) {
		 
	        String myCodeText = args;
	        myCodeText = UriCodec.decodeURIComponent(myCodeText);
	        String filePath = "/Users/jonas/CrunchifyQR.png";
	        int size = 300;
	        String fileType = "png";
	        File myFile = new File(filePath);
	        BufferedImage image = null;
	        
	            Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
	            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	            QRCodeWriter qrCodeWriter = new QRCodeWriter();
	            BitMatrix byteMatrix;
	            try {
					
						byteMatrix = qrCodeWriter.encode(myCodeText,BarcodeFormat.QR_CODE, size, size, hintMap);
				
				
	            int CrunchifyWidth = byteMatrix.getWidth();
	            image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
	                    BufferedImage.TYPE_INT_RGB);
	            image.createGraphics();
	 
	            Graphics2D graphics = (Graphics2D) image.getGraphics();
	            graphics.setColor(Color.WHITE);
	            graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth);
	            graphics.setColor(Color.BLACK);
	 
	            for (int i = 0; i < CrunchifyWidth; i++) {
	                for (int j = 0; j < CrunchifyWidth; j++) {
	                    if (byteMatrix.get(i, j)) {
	                        graphics.fillRect(i, j, 1, 1);
	                    }
	                }
	            }
	            
	            
	        	} catch (WriterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            return image;
	            //ImageIO.write(image, fileType, myFile);
	        
	      
			/*
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        */
	        
	 
	 }
}
