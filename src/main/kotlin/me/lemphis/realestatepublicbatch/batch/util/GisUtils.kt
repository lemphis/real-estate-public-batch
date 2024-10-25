package me.lemphis.realestatepublicbatch.batch.util

import org.locationtech.jts.geom.MultiPolygon
import org.locationtech.jts.geom.Polygon
import org.locationtech.proj4j.CRSFactory
import org.locationtech.proj4j.CoordinateTransformFactory
import org.locationtech.proj4j.ProjCoordinate

class GisUtils {
    companion object {
        private val crsFactory = CRSFactory()
        private val transformFactory = CoordinateTransformFactory()
        private val sourceCRS = crsFactory.createFromName("EPSG:5186")
        private val targetCRS = crsFactory.createFromName("EPSG:4326")
        private val transfer = transformFactory.createTransform(sourceCRS, targetCRS)

        fun transform(item: MultiPolygon) {
            for (i in 0 until item.numGeometries) {
                val polygon = item.getGeometryN(i) as Polygon
                polygon.coordinates.map { coordinate ->
                    val source = ProjCoordinate(coordinate.x, coordinate.y)
                    val target = ProjCoordinate()
                    transfer.transform(source, target)
                    coordinate.x = target.y
                    coordinate.y = target.x
                    item.srid = 4326
                }
            }
        }
    }
}
