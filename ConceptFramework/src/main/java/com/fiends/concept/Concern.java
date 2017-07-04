package com.fiends.concept;

/**
 * A Concern is a group of related concepts that concerns a client.
 *
 * * For example, the monster hunter game is initially concerned with Agents, Monsters, Traits, Names, and Genders
 *
 * * We need some mechanism to:
 *    * identify concepts that match a concern
 *    * identify relations between concerns
 *    * map concept relations to concern relations
 *
 * @author fwhaslam
 * @since 1.0.0
 */
public class Concern {

	final Concept concept;

	public Concern(Concept concept){
		this.concept = concept;
	}
}
