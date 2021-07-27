package com.tencent.wework;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import javax.crypto.Cipher;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;


public class RSAEncrypt {
    private static final int MAX_DECRYPT_BLOCK = 128;
    public static final String KEY_ALGORITHM = "RSA";

    /**
     * 获取公钥的key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";


    public static String decryptRSA(String str, String privateKey) throws Exception {
        try {
            byte[] signPrivate = Base64.decodeBase64(privateKey.getBytes());
            //byte[] signPrivate = privateKey.getBytes();
//            byte[] data=Base64.decodeBase64(str);
            byte[] data=Base64.decodeBase64(str);
            PKCS8EncodedKeySpec priv_spec = new PKCS8EncodedKeySpec(
                    signPrivate);
            KeyFactory mykeyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privKey = mykeyFactory.generatePrivate(priv_spec);
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privKey);
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;
            byte[] cache;
            int i = 0;
            while (inputLen - offSet > 0) {
                System.out.println(inputLen);
                if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }
                out.write(cache, 0, cache.length);
                i++;
                offSet = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            String outStr = new String(decryptedData,"UTF-8");
            return outStr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }


    public static PrivateKey getPrivateKey (String privateKey) throws Exception {
        Reader privateKeyReader = new StringReader(privateKey);
        PEMParser privatePemParser = new PEMParser(privateKeyReader);
        Object privateObject = privatePemParser.readObject();
        if (privateObject instanceof PEMKeyPair) {
            PEMKeyPair pemKeyPair = (PEMKeyPair) privateObject;
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
            PrivateKey privKey = converter.getPrivateKey(pemKeyPair.getPrivateKeyInfo());
            return privKey;
        }
        return null;
    }
    public static byte[] toPkcs8(final PrivateKey privateKey) throws IOException {
        String keyFormat = privateKey.getFormat();
        if (keyFormat.equals("PKCS#1")) {
            final byte[] encoded = privateKey.getEncoded();
            final PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(encoded);
            final ASN1Encodable asn1Encodable = privateKeyInfo.parsePrivateKey();
            final ASN1Primitive asn1Primitive = asn1Encodable.toASN1Primitive();
            final byte[] privateKeyPKCS8Formatted = asn1Primitive.getEncoded(ASN1Encoding.DER);
            return privateKeyPKCS8Formatted;
        }
        return privateKey.getEncoded();
    }

}
