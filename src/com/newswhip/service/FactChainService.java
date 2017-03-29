package com.newswhip.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.newswhip.pojo.FactChainWrapper;

public class FactChainService {

	// ===========================================================
	// Constants
	// ===========================================================

	// ===========================================================
	// Fields
	// ===========================================================

	// ===========================================================
	// Constructors
	// ===========================================================

	// ===========================================================
	// Getter & Setter
	// ===========================================================

	// ===========================================================
	// Methods for/from SuperClass/Interfaces
	// ===========================================================

	// ===========================================================
	// Methods
	// ===========================================================
	public HashCodeKeys hashFactChain(Object factChainWrapper) {
		String factChainString = factChainWrapper.toString();
		return this.hashCode(factChainString);

	}

	public HashCodeKeys hashCode(String factChainString) {
		Random rand = new Random();

		int ranNum = rand.nextInt(50) + 1;
		return new HashCodeKeys(ranNum * factChainString.hashCode(), ranNum);
	}

	public void writeFileToDisk(FactChainWrapper factChainWrapper,
			String fileName) {
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(factChainWrapper.toString());

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

	// ===========================================================
	// Inner and Anonymous Classes
	// ===========================================================
	public class HashCodeKeys {
		long hCode;
		int hKey;

		public long gethCode() {
			return hCode;
		}

		public void sethCode(long hCode) {
			this.hCode = hCode;
		}

		public int gethKey() {
			return hKey;
		}

		public void sethKey(int hKey) {
			this.hKey = hKey;
		}

		public HashCodeKeys(long hCode, int hKey) {
			super();
			this.hCode = hCode;
			this.hKey = hKey;
		}
	}

}
