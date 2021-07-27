package com.tencent.wework;

import org.json.JSONArray;
import org.json.JSONObject;
public class FinanceTestDemo {

    static String priKey =
            //"-----BEGIN RSA PRIVATE KEY-----\n"+
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
//        "NAOtEEwQNVGJZubQSUpRSn5dJYAMt60AxBp+4WQBHsE=\n";
    //"-----END RSA PRIVATE KEY-----\n";
            //"-----BEGIN PRIVATE KEY-----\n"+
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
                        "rQDEGn7hZAEewQ==\n";
                        //"-----END PRIVATE KEY-----\n";
    public static void main(String[] args) {


        long sdk = Finance.NewSdk();
        System.out.println(Finance.Init(sdk, "ww5c089adff71ad11e", "-prvrmo9SA_M8zJ41mYqnfJyBeU4IRsOTNbsfbavWEk"));


        long ret = 0;
        int seq = 0;
        int limit =20;
        long slice = Finance.NewSlice();
        ret = Finance.GetChatData(sdk, seq, limit,null, null, 3, slice);
        if (ret != 0) {
            System.out.println("getchatdata ret " + ret);
            return;
        }
        String getchatdata = Finance.GetContentFromSlice(slice);
        JSONObject jo = new JSONObject(getchatdata);
        System.out.println(jo.toString());
        JSONArray chatdata = jo.getJSONArray("chatdata");
        System.out.println("消息数:" + chatdata.length());
        for (int i = 0; i < chatdata.length(); i++) {
            String item = chatdata.get(i).toString();
            JSONObject data = new JSONObject(item);
            String encrypt_random_key = data.getString("encrypt_random_key");
            String encrypt_chat_msg = data.getString("encrypt_chat_msg");
            long msg = Finance.NewSlice();
            try {
                String message = RSAEncrypt.decryptRSA(encrypt_random_key,priKey);
                ret = Finance.DecryptData(sdk, message, encrypt_chat_msg, msg);
                if (ret != 0) {
                    System.out.println("getchatdata ret " + ret);
                    return;
                }
                System.out.println("decrypt ret:" + ret + " msg:" + Finance.GetContentFromSlice(msg));
                Finance.FreeSlice(msg);
                System.out.println(message);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        Finance.FreeSlice(slice);
    }
}

