package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from  sky_take_out.employee where username = #{username}")
    Employee getByUsername(String username);

    //{}里面的数据名对应的是实体类，不是表中的名
    @Insert("insert into sky_take_out.employee values(null,#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    void save(Employee employee);

    //分页查询
   Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

     //修改员工信息
    void update(Employee employee);

    //根据id查询员工信息
    @Select("select * from sky_take_out.employee where id=#{id}")
    Employee getById(Long id);
}
