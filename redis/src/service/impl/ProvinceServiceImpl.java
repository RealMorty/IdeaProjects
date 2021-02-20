package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.ProvinceDao;
import dao.impl.ProvinceDaoImpl;
import domain.Province;
import jedis.util.JedisPoolUtils;
import redis.clients.jedis.Jedis;
import service.ProvinceService;

import java.util.ArrayList;
import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        System.out.println(2);
        Jedis jedis = JedisPoolUtils.getJedis();
        System.out.println(4);
        String province_json = jedis.get("province");
        List<Province> ps;
        if (province_json==null || province_json.length()==0) {
            System.out.println("redis doesn't have this data...");
            ps = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                String string = mapper.writeValueAsString(ps);
                jedis.set("province",string);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.close();
        }
        return jedis.get("province");
    }
}
