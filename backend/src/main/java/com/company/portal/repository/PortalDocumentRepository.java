package com.company.portal.repository;
import com.company.portal.model.PortalDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface PortalDocumentRepository extends JpaRepository<PortalDocument, Long> { List<PortalDocument> findByCategoryIgnoreCase(String category); }
