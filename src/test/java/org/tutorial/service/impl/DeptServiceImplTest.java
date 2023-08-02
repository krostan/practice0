package org.tutorial.service.impl;


import org.junit.BeforeClass;
import org.junit.Test;
import org.tutorial.dao.DeptDAO;
import org.tutorial.dao.impl.DeptDAOImpl;
import org.tutorial.model.DeptDO;
import org.tutorial.model.EmpDO;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DeptServiceImplTest {

    private static DeptDAO dao;

    @BeforeClass
    public static void init() {
        dao = new DeptDAOImpl();
    }

    @Test
    public void getAll() {

        List<DeptDO> deptDOs = dao.getAll();

        // 印出 所有DeptDO
        for(DeptDO deptDO : deptDOs){
            System.out.print(deptDO.getDeptno() + ", ");
            System.out.print(deptDO.getDname() + ", ");
            System.out.print(deptDO.getLoc());
            System.out.println();
        }
    }

    @Test
    public void getOneDept() {

        DeptDO deptDO = dao.findByPrimaryKey(10);

        // 取得該筆資料後, 根據資料庫裡的值, 與其做比對
        assertEquals(Integer.valueOf(10), deptDO.getDeptno());
        assertEquals("財務部", deptDO.getDname());
        assertEquals("臺灣台北", deptDO.getLoc());
    }

    @Test
    public void update() {

        DeptDO deptDO = new DeptDO();
        deptDO.setDeptno(20);
        deptDO.setDname("財務部");
        deptDO.setLoc("臺灣台北");

        dao.update(deptDO);

        DeptDO testDeptDO = dao.findByPrimaryKey(20);

        // 更新完後, 取出該筆資料, 與deptDO 比對
        assertEquals(testDeptDO.getDeptno(), deptDO.getDeptno());
        assertEquals(testDeptDO.getDname(), deptDO.getDname());
        assertEquals(testDeptDO.getLoc(), deptDO.getLoc());

    }

    @Test
    public void getEmpsByDeptno() {
        List<EmpDO> empDOs = dao.getEmpsByDeptno(10);

        // 印出 所有EmpDO
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

    @Test
    public void deleteDept() {
        dao.delete(41);

        // 刪除該筆資料後, 判斷是否為null
        DeptDO deptDO = dao.findByPrimaryKey(41);

        assertNull(deptDO);
    }
}
