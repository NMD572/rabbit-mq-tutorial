package vn.nmd.sender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.nmd.sender.entity.Job;

public interface JobRepository extends JpaRepository<Job, Long>{

}
