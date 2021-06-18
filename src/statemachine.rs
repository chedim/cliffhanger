mod mutation;
mod mutation_rule;
mod node;
mod value;

use std::collections::HashMap;
use std::collections::VecDeque;

pub use mutation::Mutation;
pub use node::Node;
pub use value::Value;

pub struct StateMachine {
    mutations : VecDeque<Mutation>,
    data: HashMap<i64, Node>
}

pub trait Mutable {
    fn mutate(&mut self, value: Value);
    fn value(&self) -> Value;
    fn addRule(&mut self, rule:MutationRule);
    fn removeRule(&mut self, rule: MutationRule);
}

#[cfg(test)]
mod should {
    use super::*;

    #[test]
    fn construct_new_machines() {
        let machine = StateMachine::new();
        
        assert!(machine.mutations.len() == 0);
        assert!(machine.data.len() == 0);
    }
    
    #[test]
    fn accept_new_mutations() {
        let mut machine = StateMachine::new();

        let mutation = mock!;

        machine.queue(mutation);
        assert!(machine.mutations.len() =




          ......}

    #[test]
    fn test_execute_mutation() {
        let mut machine = StateMachine::new();
    }
}

impl StateMachine {
    fn new() -> StateMachine {
        return StateMachine {
            mutations: VecDeque::new(),
            data: HashMap::new()
        }
    }
    fn queue(&mut self, mutation: Mutation) {
        self.mutations.push_back(mutation);
    }
}
