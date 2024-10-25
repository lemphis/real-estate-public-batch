package me.lemphis.realestatepublicbatch.job.gis.buildingpolygon

import me.lemphis.realestatepublicbatch.batch.reader.ShapeFileItemReader
import org.geotools.api.feature.simple.SimpleFeature
import org.locationtech.jts.geom.MultiPolygon
import org.springframework.batch.item.file.builder.MultiResourceItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import java.util.Date

@Configuration
class BuildingPolygonFileItemReader {

    @Bean
    fun buildingPolygonMultiFileItemReader() = MultiResourceItemReaderBuilder<BuildingPolygonFileSpec>()
        .name("buildingPolygonMultiFileItemReader")
        .resources(*PathMatchingResourcePatternResolver().getResources("file:/var/gis/buildingpolygon/**/*.shp"))
        .delegate(buildingPolygonFileItemReaderDelegate())
        .build()

    private fun buildingPolygonFileItemReaderDelegate() = object : ShapeFileItemReader<BuildingPolygonFileSpec>() {
        override fun toShapeFileSpec(feature: SimpleFeature) = BuildingPolygonFileSpec(
            polygon = feature.getAttribute("the_geom") as MultiPolygon,
            원천도형ID = feature.getAttribute("A0") as Int,
            GIS건물통합식별번호 = feature.getAttribute("A1") as String,
            고유번호 = feature.getAttribute("A2") as String,
            법정동코드 = feature.getAttribute("A3") as String,
            법정동명 = feature.getAttribute("A4") as String,
            지번 = feature.getAttribute("A5") as String,
            특수지코드 = feature.getAttribute("A6") as String,
            특수지구분명 = feature.getAttribute("A7") as String,
            건축물용도코드 = feature.getAttribute("A8") as String?,
            건축물용도명 = feature.getAttribute("A9") as String,
            건축물구조코드 = feature.getAttribute("A10") as String?,
            건축물구조명 = feature.getAttribute("A11") as String,
            건축물면적 = feature.getAttribute("A12") as Double?,
            사용승인일자 = feature.getAttribute("A13") as String,
            연면적 = feature.getAttribute("A14") as Double,
            대지면적 = feature.getAttribute("A15") as Double?,
            높이 = feature.getAttribute("A16") as Double?,
            건폐율 = feature.getAttribute("A17") as Double?,
            용적율 = feature.getAttribute("A18") as Double?,
            건축물ID = feature.getAttribute("A19") as String?,
            위반건축물여부 = feature.getAttribute("A20") as String,
            참조체계연계키 = feature.getAttribute("A21") as String?,
            데이터기준일자 = feature.getAttribute("A22") as Date,
            원천시도시군구코드 = feature.getAttribute("A23") as String,
            건물명 = feature.getAttribute("A24") as String?,
            건물동명 = feature.getAttribute("A25") as String?,
            지상층수 = feature.getAttribute("A26") as Int?,
            지하층수 = feature.getAttribute("A27") as Int?,
            데이터생성변경일자 = feature.getAttribute("A28") as String,
        )
    }

}
