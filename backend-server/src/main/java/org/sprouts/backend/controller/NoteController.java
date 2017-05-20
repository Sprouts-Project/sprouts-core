package org.sprouts.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sprouts.backend.service.AuthorityService;
import org.sprouts.backend.service.NoteService;
import org.sprouts.model.Authority;
import org.sprouts.model.Note;

import java.util.Collection;

@RestController
@RequestMapping("/note")
public class NoteController extends AbstractController {

	// Supporting services ----------------------------------------------------

	@Autowired
	private NoteService noteService;

	// API endpoints ----------------------------------------------------------

	@RequestMapping(value = "/user/findByPrincipal", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Note> findByPrincipal() throws Exception {
		return noteService.findByPrincipal();
	}

    @RequestMapping(value = "/findAllPublic", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Note> findAllPublic() throws Exception {
        return noteService.findAllPublic();
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public int save(@RequestParam Note note) throws Exception {
        return noteService.save(note);
    }
}