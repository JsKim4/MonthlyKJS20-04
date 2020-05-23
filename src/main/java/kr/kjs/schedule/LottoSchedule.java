package kr.kjs.schedule;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import kr.kjs.admin.service.AdminService;
import kr.kjs.dto.LottoDTO;
import kr.kjs.service.LottoService;
import lombok.extern.java.Log;

@Log
public class LottoSchedule {

	@Autowired
	LottoService service;

	@Autowired
	AdminService adminService;

	@Autowired
	RestTemplate restTemplate;

	static final String LOTTO_URL = "https://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=";

	@Scheduled(cron = "1 * * * * *")
	public void insertSchedule() {

		try {

			List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
			MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
			ignoreSsl();
			converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
			messageConverters.add(converter);
			restTemplate.setMessageConverters(messageConverters);
			log.info(LOTTO_URL + (service.getLastDrwNo() + 1));
			LottoDTO lottoDTO = restTemplate.getForObject(LOTTO_URL + (service.getLastDrwNo() + 1), LottoDTO.class);
			log.info(lottoDTO.toString());

			if (lottoDTO == null)
				log.warning("Data Insert Failure pls Check" + 7);
			else
				service.insertLotto(lottoDTO);


		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void ignoreSsl() throws Exception {
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				return true;
			}
		};
		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}

	private static void trustAllHttpsCertificates() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[1];
		TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}

	static class miTM implements TrustManager, X509TrustManager {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}

		public boolean isServerTrusted(X509Certificate[] certs) {
			return true;
		}

		public boolean isClientTrusted(X509Certificate[] certs) {
			return true;
		}

		public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
			return;
		}

		public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
			return;
		}
	}
}
