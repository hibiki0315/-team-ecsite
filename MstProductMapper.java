package jp.co.internous.printemps.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.printemps.model.domain.MstProduct;

@Mapper
public interface MstProductMapper {
	@Select("SELECT * FROM mst_product")
	List<MstProduct> find();
	
}
