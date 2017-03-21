package com.unionlive.util.encrypt;

import java.util.Base64;

/**
 * Base64工具类
 *
 *
 */
public class Base64Code {


    public byte[] string2bytes(String v){
        return  Base64.getDecoder().decode(v);
    }


}
