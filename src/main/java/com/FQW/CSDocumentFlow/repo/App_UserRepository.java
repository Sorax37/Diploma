package com.FQW.CSDocumentFlow.repo;

import com.FQW.CSDocumentFlow.models.App_User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface App_UserRepository extends JpaRepository<App_User, Long> {
    App_User findByUsername(String username);
    App_User findByFIO(String FIO);
}
