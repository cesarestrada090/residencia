package com.residencial.app.infrastructure.pagination;
import com.residencial.app.application.dto.ResultPageWrapper;
import com.residencial.app.infrastructure.mapper.MapperUtil;
import org.springframework.data.domain.Page;

public class PaginationUtil {
    public static<P,E> ResultPageWrapper<P> prepareResultWrapper(Page<E> resultPages, Class<P> pojoClass) {
        ResultPageWrapper<P> resultPageWrapper = new ResultPageWrapper<>();
        resultPageWrapper.setPagesResult(MapperUtil.mapAll(resultPages.getContent(), pojoClass));
        resultPageWrapper.setCurrentPage(resultPages.getNumber());
        resultPageWrapper.setTotalItems(resultPages.getTotalElements());
        resultPageWrapper.setTotalPages(resultPages.getTotalPages());
        return resultPageWrapper;
    }

    public static<P,E> ResultPageWrapper<P> prepareCustomWrapper(Page<E> resultPages, Class<P> pojoClass) {
        ResultPageWrapper<P> resultPageWrapper = new ResultPageWrapper<>();
        resultPageWrapper.setCurrentPage(resultPages.getNumber());
        resultPageWrapper.setTotalItems(resultPages.getTotalElements());
        resultPageWrapper.setTotalPages(resultPages.getTotalPages());
        return resultPageWrapper;
    }
}
