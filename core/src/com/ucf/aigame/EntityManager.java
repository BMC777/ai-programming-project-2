package com.ucf.aigame;

import com.ucf.aigame.component.Component;

import java.util.*;

/**
 * <h1>EntityManager</h1>
 * The EntityManager class manages the List globalEntityList containing Integers representing
 * Entities.
 *
 * @author Bryan Casey
 * @version 0.1.0
 * @since 0.1.0
 */

/**
 * TODO: Create an Aspects class and change all Class<A> objects to Aspect objects.
 * TODO: Possibly create a ComponentManager class to further separate Entities and Components.
 */
public class EntityManager
{
    private int baseUnassignedEntityID = 1;

    List<Integer> globalEntityList;
    HashMap<Class<?>, HashMap<Integer, ? extends Component>> AspectMap;

    public EntityManager()
    {
        globalEntityList = new LinkedList<Integer>();
        AspectMap = new HashMap<Class<?>, HashMap<Integer, ? extends Component>>();
    }

    public int createEntity()
    {
        int nextEntityID = generateNextEntityID();
        globalEntityList.add(nextEntityID);

        return nextEntityID;
    }

    public <A extends Component> void addComponent( int entity, A newComponent )
    {
        //Check to see if the newComponent's Aspect already exists within AspectMap.
        HashMap<Integer, ? extends Component> tempAspect = AspectMap.get( newComponent.getClass() );

        //If an Aspect does not exist for the newComponent, create a new Aspect ID and store a null.
        if ( tempAspect == null)
        {
            tempAspect = new HashMap<Integer, A>();
            AspectMap.put( newComponent.getClass(), tempAspect );
        }

        //
        ((HashMap<Integer, A>)tempAspect).put(entity, newComponent);
    }

    public <A extends Component> A getComponent( int entityID, Class<A> componentAspect )
    {
        //Get the map of Components with Aspect componentAspect
        HashMap<Integer, ? extends Component> componentMap = AspectMap.get( componentAspect );

        //Get the entity's component, and cast it to the correct Aspect
        A foundComponent = componentAspect.cast(componentMap.get(entityID));

        return foundComponent;
    }

    public <A extends Component> Set<Integer> getEntitiesWithAspect( Class<A> componentAspect )
    {
        HashMap<Integer, ? extends Component> tempAspect = AspectMap.get( componentAspect );

        if ( tempAspect == null )
        {
            return new HashSet<Integer>();  //Small data set, easy to see that it contains null values.
        }

        return tempAspect.keySet();
    }

    public void destroyEntity( int entityToDestroy )
    {
        globalEntityList.remove(entityToDestroy);
    }

    //Messy, re-do later. (Maybe create an Aspect class)
    public <A extends Component> List<A> getComponentsWithAspect( Class<A> componentAspect )
    {
        HashMap<Integer, ? extends Component> componentMap = AspectMap.get( componentAspect );

        if ( componentMap == null )
        {
            //Worst-Case insertion using Linked List is fast so initialize a new Aspect as a Linked List
            return new LinkedList<A>();
        }
        else
        {
            //Worst-Case access of an ArrayList is fast so initialize a Aspect ArrayList via a Collection of components
            List<A> componentList = new ArrayList<A>((java.util.Collection<A>)componentMap.values());
            return componentList;
        }
    }

    private int generateNextEntityID()
    {
        //Possibly needs synchronization to prevent creation of same ID at the same time.
        return baseUnassignedEntityID++;
    }
}
