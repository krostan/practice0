package org.tutorial.service.impl;

import org.junit.BeforeClass;
import org.junit.Test;
import org.tutorial.dao.EmpDAO;
import org.tutorial.dao.impl.EmpDAOImpl;
import org.tutorial.model.EmpDO;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EmpServiceImplTest {

    private static EmpDAO dao;

    @BeforeClass
    public static void init(){
        dao = new EmpDAOImpl();
    }

    @Test
    public void addEmp() {

        EmpDO empDO = new EmpDO();

        empDO.setEname("leo");
        empDO.setJob("diver");
        empDO.setHiredate(LocalDate.parse("1999-10-01"));
        empDO.setSal(1000.0);
        empDO.setComm(0.0);
        empDO.setDeptno(10);

        dao.insert(empDO);

        // 新增後, 取出資料, 與 empDO 比對
        EmpDO testEmpDO = dao.findByPrimaryKey(15);

        assertEquals(testEmpDO.getEname(), empDO.getEname());
        assertEquals(testEmpDO.getJob(), empDO.getJob());
        assertEquals(testEmpDO.getHiredate(), empDO.getHiredate());
        assertEquals(testEmpDO.getSal(), empDO.getSal());
        assertEquals(testEmpDO.getComm(), empDO.getComm());
        assertEquals(testEmpDO.getDeptno(), empDO.getDeptno());

    }

    @Test
    public void updateEmp() {

        EmpDO empDO = new EmpDO();

        empDO.setEmpno(2);
        empDO.setEname("leo2");
        empDO.setJob("sleeper");
        empDO.setHiredate(LocalDate.parse("1999-10-01"));
        empDO.setSal(1000.0);
        empDO.setComm(0.0);
        empDO.setDeptno(10);

        dao.update(empDO);

        // 新增後, 取出資料, 與 empDO 比對
        EmpDO testEmpDO = dao.findByPrimaryKey(2);

        assertEquals(testEmpDO.getEmpno(), empDO.getEmpno());
        assertEquals(testEmpDO.getEname(), empDO.getEname());
        assertEquals(testEmpDO.getJob(), empDO.getJob());
        assertEquals(testEmpDO.getHiredate(), empDO.getHiredate());
        assertEquals(testEmpDO.getSal(), empDO.getSal());
        assertEquals(testEmpDO.getComm(), empDO.getComm());
        assertEquals(testEmpDO.getDeptno(), empDO.getDeptno());

    }

    @Test
    public void deleteEmp() {

        dao.delete(3);

        // 刪除該筆資料後, 判斷是否為null
        EmpDO empDO = dao.findByPrimaryKey(3);

        assertNull(empDO);
    }

    @Test
    public void getOneEmp() {
        EmpDO empDO = dao.findByPrimaryKey(1);

        // 比對找到的資料的值, 是否與資料庫相同
        assertEquals(Integer.valueOf(1), empDO.getEmpno());
        assertEquals("king", empDO.getEname());
        assertEquals("president", empDO.getJob());
        assertEquals(LocalDate.parse("1981-11-17"), empDO.getHiredate());
        assertEquals(Double.valueOf(5000.5), empDO.getSal());
        assertEquals(Double.valueOf(0.0), empDO.getComm());
        assertEquals(Integer.valueOf(10), empDO.getDeptno());
    }

    @Test
    public void getAll() {
        List<EmpDO> empDOs = dao.getAll();

        // 顯示 所有EmpDO
        for(EmpDO empDO : empDOs){
            System.out.print(empDO.getEmpno() + ", ");
            System.out.print(empDO.getEname() + ", ");
            System.out.print(empDO.getJob() + ", ");
            System.out.print(empDO.getHiredate() + ", ");
            System.out.print(empDO.getSal() + ", ");
            System.out.print(empDO.getComm() + ", ");
            System.out.print(empDO.getDeptno());
            System.out.println();
        }
    }
}
