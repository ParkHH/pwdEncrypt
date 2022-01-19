package kccglass.encoder.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JTextField;

import kccglass.encoder.core.AES256Cipher;

public class UiProcess implements ActionListener{
	EncoderUi encoderUi;
	AES256Cipher pwEncry = new AES256Cipher();
	
	public UiProcess(EncoderUi encoderUi) {
		this.encoderUi = encoderUi;		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object inputVal = (JTextField)e.getSource();
		textInputAction(inputVal);
	}
	
	
	/**
	 * 입력한 텍스트 비밀번호를 암호화 처리하는 Method
	 * AES256, BASE64 암호화
	 * @param inputVal
	 */
	public void textInputAction(Object inputVal) {
		String tf1Text = null;
		String errorText = null;
		String encryPwText = null;
		if(inputVal == encoderUi.getTf1()) {
			JTextField tf1 = encoderUi.getTf1();
			if(tf1 != null) {
				// 입력한 Text 암호화 진행
				tf1Text = tf1.getText();	
				errorText = null;
				
				if(tf1Text != null) {
					if(!tf1Text.equals("")&&tf1Text!="") {
						try {
							encryPwText = AES256Cipher.AES_Encode( tf1Text );
						} catch (InvalidKeyException e) {
							e.printStackTrace();
							errorText = e.getMessage();
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
							errorText = e.getMessage();
						} catch (NoSuchAlgorithmException e) {
							e.printStackTrace();
							errorText = e.getMessage();
						} catch (NoSuchPaddingException e) {
							e.printStackTrace();
							errorText = e.getMessage();
						} catch (InvalidAlgorithmParameterException e) {
							e.printStackTrace();
							errorText = e.getMessage();
						} catch (IllegalBlockSizeException e) {
							e.printStackTrace();
							errorText = e.getMessage();
						} catch (BadPaddingException e) {
							e.printStackTrace();
							errorText = e.getMessage();
						} finally {				
							if(errorText != null) {
								encoderUi.getTa1().setText(errorText);
							}else {
								encoderUi.getTa1().setText(encryPwText);										
							}
							//
						}
					}else {
						encoderUi.getTa1().setText("※지정되는 암호화된 password 를\n확인하는 용도로 사용\n\n입력한 텍스트 암호를 암호화한 결과를 출력합니다.\n**암호화 방식 : AES256, BASE64");
					}
				}
			
			}		
		}
	}
}
