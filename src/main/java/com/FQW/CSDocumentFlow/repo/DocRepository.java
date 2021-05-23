package com.FQW.CSDocumentFlow.repo;

import com.FQW.CSDocumentFlow.models.Doc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocRepository extends JpaRepository <Doc, Long> {
}
