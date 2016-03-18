package cn.com.lianbi.ims.user.web;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * @since 2016年3月18日 上午11:51:21
 * @author junhong.xie
 */
public class Test {

	/**
	 * @author junhong.xie
	 * @param args
	 * @throws EmailException 
	 */
	public static void main(String[] args) throws EmailException {
		// 需要的jar: mail-1.4.7.jar、commons-email-1.4.jar
		// 使用的QQ邮箱测试时，密码不管用，需要账户生成的随机授权码
		Email email = new SimpleEmail();
		email.setHostName("smtp.qq.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("447912696@qq.com", "igicccmcaezsdahh"));
		email.setSSLOnConnect(true);
		email.setFrom("447912696@qq.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("1702047@qq.com");
		email.send();
	}

}
