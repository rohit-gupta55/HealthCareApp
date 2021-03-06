package in.nit.rohit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.nit.rohit.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
	
	@Query("SELECT id, firstName,lastName FROM Doctor")
	public List<Object[]> getDoctorIdAndName();
	
	@Query("SELECT doct FROM Doctor doct INNER JOIN doct.specialization as spec WHERE spec.id=:specId")
	public List<Doctor> findDoctorBySpecId(Long specId);

}
