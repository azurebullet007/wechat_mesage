import com.tencent.wework.Finance;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.util.Base64;



public class messagesdk {
    public static void main(String[] args) throws Exception {
         args =new String[6];
         args[0] = "2";
         args[1] = "3";
         args[2] = "20";
        //  args[1] = "HTGqHWbZQbH85SXXj5BBt1yJ6Y4RiGdfxv/eGjHmiaAqAnKgF9arInRUdPLiMEmSngz5t7k7Riynpn3AhyQEBLI5+HI5uUg5/9qnW6fzBoUMmvmbfyCofe169nyKKnoYc0u7aLaDeRBh45hPiCtmunIu/SUIwtVefJHYjypY0fQ=";
        //  args[2] = "qb1CVblfr3O7owDjdLBJz6Jg0mZxLNdNqTD+/gqn+WQ15NmHVn8NKTBw9KzQPUCFhXS161DDFx1aO4gEr/hhjFbNjua/qtwYMqckUhhbwJvZ10KzyqahqFaQcFGH8jVhDVVdwkmFRUgTFUdew6esOEp832Md3T6YA01sBqhq4ZB7Gal92BeHV5OxIWG55DttCC8uk1ZdPn7z1ZSjDnBlUHEm6und3XlwgBq6ygvfOillN1ekGSn81gFMUgAF9FkkU257UFeUpMPXWWIS8TDdSzhccsAANbG00rxN44QRrm8vDqSR998zgOEmdCV5wPn2ch6OB6lUkNAktO9Ud9aq+VvSDa/FRNAfn9K2TJ0NOM2EVS3jqZ0uNCKCt6gra5+yyyv+YyPD/WE+2";
         args[3] = "";
         args[4] = "";
         args[5] = "3";
        
        long sdk = Finance.NewSdk();
        System.out.println(Finance.Init(sdk, "ww5c089adff71ad11e", "-prvrmo9SA_M8zJ41mYqnfJyBeU4IRsOTNbsfbavWEk"));
        String priKey =
                "-----BEGIN PRIVATE KEY-----\n"+
                "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAM5VZMD7plA3kakP\n"+
        "ydWCoghNPHbWmnhWV9HRwDyJ5VYOi8kmDCttcXCwYIc6u3o6hQHr0I6gcW0JHa2o\n"+
        "NaBTUacWl9RNcZamH8bXHqhT6KDHze0NbE1ojIRj7gLV32+ljBZ9DupPSaJgjSoq\n"+
        "Eusj62OaN0f/LdLn63U4P9Dm/OLZAgMBAAECgYAHof5QCsciXsnhRYuffb2Bfdzz\n"+
        "nvj4JGaLhR09yBKfKjrW0jTfSuVISEgL3Jr4mK9YrLjqe8oyYMTTqp4wPADQUujc\n"+
        "eoyvnxbNWc5jGHs/BIjIrkBHhJTjeDeSr7DstsxcelSI+gihfyj9f2vmuLEN5cux\n"+
        "3Ec5qEKT5sd4F2ETcQJBAN5qWL2tysnnX0LBpNDSz+qNByk1XwdNalKbJAji2H0Z\n"+
        "hosjeMTScTkR/4SnyMH9KPD+h8w+kxH5gUaFLMgt5NECQQDtfWPCbsMAOQtlxWrM\n"+
        "Dejberbsu3nv9CoDspNF4V7QKaxRAYUYTo+5BIqMWbxbAu3sTcmB3tK0pRpUZOYo\n"+
        "vj+JAkA15/iSIGkh/l3sRBq6Mh4KbxvpNPJPRsgaNVfKf5CQ4XrmhjZjHc4rUt1n\n"+
        "PXM+8SjXIBmxuwjSNnLKsMRl0BnBAkABnqxShCziUIFKZWlQEPw4mwKqZLD1OQYc\n"+
        "Vlh4zou2AcLCHq+Iteh3C5fiUy5ctI1o4jLwptNrFgEy+Ck1t+55AkEA05ePW/Ws\n"+
        "BJ5A6XHVwAe2CrUPAkH7v43OZU173/k+2p40A60QTBA1UYlm5tBJSlFKfl0lgAy3\n"+
        "rQDEGn7hZAEewQ==\n"+
                "-----END PRIVATE KEY-----\n";
//        String priKey =
//                "-----BEGIN RSA PRIVATE KEY-----\n"+
//                "MIICXAIBAAKBgQDOVWTA+6ZQN5GpD8nVgqIITTx21pp4VlfR0cA8ieVWDovJJgwr\n"+
//        "bXFwsGCHOrt6OoUB69COoHFtCR2tqDWgU1GnFpfUTXGWph/G1x6oU+igx83tDWxN\n"+
//        "aIyEY+4C1d9vpYwWfQ7qT0miYI0qKhLrI+tjmjdH/y3S5+t1OD/Q5vzi2QIDAQAB\n"+
//        "AoGAB6H+UArHIl7J4UWLn329gX3c8574+CRmi4UdPcgSnyo61tI030rlSEhIC9ya\n"+
//                "+JivWKy46nvKMmDE06qeMDwA0FLo3HqMr58WzVnOYxh7PwSIyK5AR4SU43g3kq+w\n"+
//        "7LbMXHpUiPoIoX8o/X9r5rixDeXLsdxHOahCk+bHeBdhE3ECQQDeali9rcrJ519C\n"+
//        "waTQ0s/qjQcpNV8HTWpSmyQI4th9GYaLI3jE0nE5Ef+Ep8jB/Sjw/ofMPpMR+YFG\n"+
//        "hSzILeTRAkEA7X1jwm7DADkLZcVqzA3o23q27Lt57/QqA7KTReFe0CmsUQGFGE6P\n"+
//        "uQSKjFm8WwLt7E3Jgd7StKUaVGTmKL4/iQJANef4kiBpIf5d7EQaujIeCm8b6TTy\n"+
//        "T0bIGjVXyn+QkOF65oY2Yx3OK1LdZz1zPvEo1yAZsbsI0jZyyrDEZdAZwQJAAZ6s\n"+
//        "UoQs4lCBSmVpUBD8OJsCqmSw9TkGHFZYeM6LtgHCwh6viLXodwuX4lMuXLSNaOIy\n"+
//        "8KbTaxYBMvgpNbfueQJBANOXj1v1rASeQOlx1cAHtgq1DwJB+7+NzmVNe9/5Ptqe\n"+
//        "NAOtEEwQNVGJZubQSUpRSn5dJYAMt60AxBp+4WQBHsE=\n"+
//                "-----END RSA PRIVATE KEY-----\n";
        /**
         * 第一个是pcks#8，第二个是pcks#1格式的私钥
         */
        long ret = 0;

        if (args[0].equals("1")) {
            int seq = Integer.parseInt(args[1]);
            int limit = Integer.parseInt(args[2]);
            long slice = Finance.NewSlice();
            ret = Finance.GetChatData(sdk, seq, limit, args[3], args[4], Integer.parseInt(args[5]), slice);
            if (ret != 0) {
                System.out.println("getchatdata ret " + ret);
                return;
            }
            System.out.println("getchatdata :" + Finance.GetContentFromSlice(slice));
            Finance.FreeSlice(slice);
        } else if (args[0].equals("2")) {
            String sdkfileid = args[1];
            String proxy = args[2];
            String passwd = args[3];
            int timeout = Integer.parseInt(args[4]);
            String savefile = args[5];
            String indexbuf = "";
            while(true){
                long media_data = Finance.NewMediaData();
                ret = Finance.GetMediaData(sdk, indexbuf, args[1], args[2], args[3], Integer.parseInt(args[4]), media_data);
                System.out.println("getmediadata ret:" + ret);
                if(ret!=0){
                    return;
                }
                System.out.printf("getmediadata outindex len:%d, data_len:%d, is_finis:%d\n",Finance.GetIndexLen(media_data),Finance.GetDataLen(media_data), Finance.IsMediaDataFinish(media_data));
                try {
                    FileOutputStream outputStream  =new FileOutputStream(new File("/home/tebon/Documents/msgdata"));
                    outputStream.write(Finance.GetData(media_data));
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if(Finance.IsMediaDataFinish(media_data) == 1)
                {
                    Finance.FreeMediaData(media_data);
                    break;
                }
                else
                {
                    indexbuf = Finance.GetOutIndexBuf(media_data);
                    Finance.FreeMediaData(media_data);
                }
    }
        }else if (args[0].equals("3")) {
            // notice!
            // // use prikey to decrpyt get args[1]
            String encrypt_random_key = args[1];
            System.out.println(encrypt_random_key);
            String encrypt_chat_msg = args[2];
            PrivateKey prikey=getPrivateKey(priKey);
            System.out.println(prikey.getAlgorithm());
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding","BC");
            cipher.init(Cipher.DECRYPT_MODE, prikey);
            byte[] randomkeybyte = Base64.getDecoder().decode(encrypt_random_key);
            System.out.println(randomkeybyte.length);
            byte[] finalrandomkeybyte = cipher.doFinal(randomkeybyte);
            String finalrandomkey = new String(finalrandomkeybyte);


            //每次使用DecryptData解密会话存档前需要调用NewSlice获取一个slice，在使用完slice中数据后，还需要调用FreeSlice释放。
            long msg = Finance.NewSlice();
            ret = Finance.DecryptData(sdk, finalrandomkey, encrypt_chat_msg, msg);
            if (ret != 0) {
                System.out.println("getchatdata ret " + ret);
                Finance.FreeSlice(msg);
                return;
            }
            System.out.println("decrypt ret:" + ret + " msg:" + Finance.GetContentFromSlice(msg));
            Finance.FreeSlice(msg);
        }
        else {
            System.out.println("wrong args " + args[0]);
        }
        Finance.DestroySdk(sdk);
    }
    public static PrivateKey getPrivateKey(String privKeyPEM) throws Exception{
        final String PEM_PRIVATE_START ="-----BEGIN PRIVATE KEY-----";
        final String PEM_PRIVATE_END ="-----END PRIVATE KEY-----";

        // PKCS#1 format
        final String PEM_RSA_PRIVATE_START ="-----BEGIN RSA PRIVATE KEY-----";
        final String PEM_RSA_PRIVATE_END ="-----END RSA PRIVATE KEY-----";



        if (privKeyPEM.indexOf(PEM_PRIVATE_START) != -1) { // PKCS#8 format
            System.out.println("this is pscs#8");
            privKeyPEM = privKeyPEM.replace(PEM_PRIVATE_START,"").replace(PEM_PRIVATE_END,"");
            privKeyPEM = privKeyPEM.replaceAll("\\s","");

            byte[] pkcs8EncodedKey = Base64.getDecoder().decode(privKeyPEM);

            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePrivate(new PKCS8EncodedKeySpec(pkcs8EncodedKey));

        } else if (privKeyPEM.indexOf(PEM_RSA_PRIVATE_START) != -1) {  // PKCS#1 format
            System.out.println("this is pscs#1");
            privKeyPEM = privKeyPEM.replace(PEM_RSA_PRIVATE_START,"").replace(PEM_RSA_PRIVATE_END,"");
            privKeyPEM = privKeyPEM.replaceAll("\\s","");

            DerInputStream derReader = new DerInputStream(Base64.getDecoder().decode(privKeyPEM));

            DerValue[] seq = derReader.getSequence(0);

            if (seq.length < 9) {
                throw new GeneralSecurityException("Could not parse a PKCS1 private key.");
            }

            // skip version seq[0];
            BigInteger modulus = seq[1].getBigInteger();
            BigInteger publicExp = seq[2].getBigInteger();
            BigInteger privateExp = seq[3].getBigInteger();
            BigInteger prime1 = seq[4].getBigInteger();
            BigInteger prime2 = seq[5].getBigInteger();
            BigInteger exp1 = seq[6].getBigInteger();
            BigInteger exp2 = seq[7].getBigInteger();
            BigInteger crtCoef = seq[8].getBigInteger();

            RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(modulus, publicExp, privateExp, prime1, prime2, exp1, exp2, crtCoef);

            KeyFactory factory = KeyFactory.getInstance("RSA");

            return factory.generatePrivate(keySpec);
        }

        throw new GeneralSecurityException("Not supported format of a private key");
    
    }

}



