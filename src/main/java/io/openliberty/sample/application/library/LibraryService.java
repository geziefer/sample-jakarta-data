/*******************************************************************************
* Copyright (c) 2023 IBM Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     IBM Corporation - initial API and implementation
*******************************************************************************/
package io.openliberty.sample.application.library;

import io.openliberty.sample.application.CrewMember;
import io.openliberty.sample.application.Rank;
import io.openliberty.sample.application.Ship;
import jakarta.data.Sort;
import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.bind.JsonbBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/library")
@ApplicationScoped
public class LibraryService {

	@Inject
	Library library;

	@GET
	@Path("/init")
	public String init() {
		library.deleteAll();

		Author author1 = new Author("J.R.R. Tolkien", 1892, Country.ENGLAND);
		Author author2 = new Author("Douglas Adams", 1952, Country.ENGLAND);
		Author author3 = new Author("Terry Pratchett", 1948, Country.ENGLAND);
		Author author4 = new Author("Antoine de Saint-Exupéry", 1900, Country.FRANCE);
		Author author5 = new Author("Isaac Asimov", 1920, Country.USA);
		Author author6 = new Author("John M. Roberts", 1947, Country.USA);
		Author author7 = new Author("Frank Schätzing", 1957, Country.GERMANY);
		Author author8 = new Author("Alexander Rühl", 1974, Country.GERMANY);

		library.store(new Book("978-0-00-847128-6", "The Lord of the Rings", author1, 1954));
		library.store(new Book("978-0-00-843394-9", "The Silmarillion", author1, 1977));
		library.store(new Book("978-1-399-61724-6", "The Hitchhiker's Guide To The Galaxy", author2, 1979));
		library.store(new Book("0-86140-324-X", "The Colour of Magic", author3, 1983));
		library.store(new Book("0-86140-203-0", "The Light Fantastic", author3, 1986));
		library.store(new Book("0-385-60984-1", "Wintersmith", author3, 2006));
		library.store(new Book("978-0-15-216415-7", "Le Petit Prince", author4, 1943));
		library.store(new Book("978-0-00-811749-8", "Foundation ", author5, 1951));
		library.store(new Book("978-0-00-811750-4", "Foundation and Empire", author5, 1952));
		library.store(new Book("978-0-00-811751-1", "Second Foundation", author5, 1953));
		library.store(new Book("978-0-00-827955-4", "I, Robot", author5, 1950));
		library.store(new Book("978-0312277055", "SPQR I", author6, 1990));
		library.store(new Book("978-3-462-03374-8", "Der Schwarm", author7, 2004));
		library.store(new Book("978-3-7408-2326-9", "Tod und Teufel", author7, 1995));
		library.store(new Book("978-94-6342-183-6", "Tod im Weinberg", author8, 2017));
		library.store(new Book("978-94-6367-531-4", "Fingerzeig", author8, 2018));

		return "Library Initialized";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String findAll() {
		return JsonbBuilder.create().toJson(library.searchAllBooks());
	}
}