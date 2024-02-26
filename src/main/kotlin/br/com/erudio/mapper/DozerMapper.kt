package br.com.erudio.mapper



object DozerMapper {

    private val mapper: Mapper = DozerBeanMapperBuilder.buildDefault()

    fun<O,D> parseObject(origin: 0, destination: Class<D>?): D {
        return mapper.map(origin, destination)
    }

    fun<O,D> parseListObjects(origin: List<0>, destination: Class<D>?): List<D> {
        val destinationObjects: ArrayList<D> = ArrayList()
        for (o in origin) {
            destinationObjects.add(mapper.map(origin, destination))
        }
        return destinationObjects
    }
}