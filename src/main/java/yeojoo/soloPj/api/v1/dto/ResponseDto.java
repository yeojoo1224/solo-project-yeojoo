package yeojoo.soloPj.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
public class ResponseDto<T> {

    private List<T> data;
    private PageInfo pageInfo;

    public ResponseDto(List<T> data, Page page){
        this.data = data;
        this.pageInfo = new PageInfo(page.getNumber()+1, page.getSize(),
                page.getTotalElements(), page.getTotalPages());
    }

    @Getter
    private class PageInfo{
        private int page;
        private int size;
        private long totalElements;
        private int totalPages;

        PageInfo(int page, int size, long totalElements, int totalPages){
            this.page = page;
            this.size = size;
            this.totalElements = totalElements;
            this.totalPages = totalPages;
        }
    }
}