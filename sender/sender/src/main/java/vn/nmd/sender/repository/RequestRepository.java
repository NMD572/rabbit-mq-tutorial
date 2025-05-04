package vn.nmd.sender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.nmd.sender.entity.Request;

public interface RequestRepository extends JpaRepository<Request, Long>{

}
