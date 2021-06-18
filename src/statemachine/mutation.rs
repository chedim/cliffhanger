mod rule;

pub use rule::Rule;

pub struct Mutation {
    target: i64,
    rule: MutationRule
}


pub fn new(target: i64, rule: MutationRule) -> Mutation {
    Mutation{
        target, rule
    }
}


impl Mutation {
}

