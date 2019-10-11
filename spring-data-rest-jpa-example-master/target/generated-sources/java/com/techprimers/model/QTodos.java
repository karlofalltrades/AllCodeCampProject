package com.techprimers.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTodos is a Querydsl query type for Todos
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTodos extends EntityPathBase<Todos> {

    private static final long serialVersionUID = 1110588951L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTodos todos = new QTodos("todos");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QUser owner;

    public final StringPath status = createString("status");

    public QTodos(String variable) {
        this(Todos.class, forVariable(variable), INITS);
    }

    public QTodos(Path<? extends Todos> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTodos(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTodos(PathMetadata metadata, PathInits inits) {
        this(Todos.class, metadata, inits);
    }

    public QTodos(Class<? extends Todos> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.owner = inits.isInitialized("owner") ? new QUser(forProperty("owner")) : null;
    }

}

