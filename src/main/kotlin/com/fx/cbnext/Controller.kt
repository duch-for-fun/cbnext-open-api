package com.fx.cbnext

import io.swagger.annotations.Api
import io.swagger.annotations.*
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.Date

@RestController
@RequestMapping("${CBNextApi.VERSION}/cbnext")
@Api(value = "/cbnext", description = "Rest API prototype for CB T+1", tags = arrayOf("cbnext API"))
class Controller(private val service: Service) {

    @GetMapping
    @ApiOperation(value = "display hello message", notes = "ping() ~ just for check", response = String::class)
    @ApiResponse(code = 200, message = "OK")
    fun ping() = "${Date()} Hey, it's CB T+1 endpoint ${CBNextApi.VERSION}"


    @GetMapping("info")
    @ApiOperation(value = "get initialization info on CB T+1", notes = "initInfo(client: String?)", response = Info::class)
    @ApiResponses(value = arrayOf(
            ApiResponse(code = 200, message = "OK"),
            ApiResponse(code = 401, message = "You are not authorized access the resource"),
            ApiResponse(code = 403, message = "Forbidden: you don’t have permission"),
            ApiResponse(code = 404, message = "The resource not found"))
    )
    fun initInfo(client: String?) = service.getInitInfo(client)


    @GetMapping("tods")
    @ApiOperation(value = "get all TOD documents", notes = "getAll()")
    fun getAll() = service.getTods()


    @GetMapping("tods/{id}")
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation(value = "get one TOD document by id", notes = "getOne(id: Long)", response = Tod::class)
    fun getOne(@PathVariable id: Long) = service.getTod(id)


    @PostMapping("tods")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "create new TOD document", notes = "create(doc: Tod)", response = Tod::class)
    fun create(@RequestBody doc: Tod) = service.saveTod(doc)


    @PutMapping("tods/{id}")
    @ApiOperation(value = "update TOD document", notes = "update(id: Long, doc: Tod)", response = Tod::class)
    fun update(@PathVariable id: Long, @RequestBody doc: Tod) = service.editTod(id, doc)


    @DeleteMapping("tods/{id}")
    @ApiOperation(value = "delete TOD document by id", notes = "delete(id: Long))")
    fun delete(@PathVariable id: Long) = service.deleteTod(id)
}